package com.weishengming.web.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.weishengming.dao.entity.JueSeQuanXianDO;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.entity.KeHuJueSeDO;
import com.weishengming.dao.mapper.JueSeQuanXianMapper;
import com.weishengming.dao.mapper.KeHuJueSeMapper;
import com.weishengming.dao.mapper.KeHuMapper;
import com.weishengming.dao.param.JueSeQuanXianParam;
import com.weishengming.dao.param.KeHuJueSeParam;

/**
 * @author 杨天赐
 * 获取
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	@Resource
	private KeHuMapper keHuMapper;
	@Resource
	private KeHuJueSeMapper keHuJueSeMapper;
	@Resource
	private JueSeQuanXianMapper jueSeQuanXianMapper;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public UserDetails loadUserByUsername(String zhanghao)throws UsernameNotFoundException {
		logger.info("认证用户" + zhanghao);// 查询数据库获取改账号的信息
		KeHuDO keHuDO = keHuMapper.findKeHuByZhangHao(zhanghao); // 通过账号 查询
		if (null == keHuDO) {
			throw new UsernameNotFoundException("账号" + zhanghao + "不存在");
		}
		Set quanxian = getQuanXians(keHuDO); // 将没有使用到的属性设置为true
		UserDetails userDetails = new User(keHuDO.getZhanghao(),keHuDO.getMima(),keHuDO.getEnabled(), true, true, true, quanxian);
		return userDetails;
	}

	// 获得客户所有角色的所有权限
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Set getQuanXians(KeHuDO keHuDO) {
		KeHuJueSeParam keHuJueSeParam=new KeHuJueSeParam();
		keHuJueSeParam.setKehuzhanghao(keHuDO.getZhanghao());
		List<KeHuJueSeDO> keHuJueSes=keHuJueSeMapper.findList(keHuJueSeParam);
		Set authoritySet = new HashSet(); // 默认所有的用户有浏览用户的权利
		authoritySet.add(new SimpleGrantedAuthority("ROLE_WEB")); // 依次添加
		if (null != keHuJueSes&& keHuJueSes.size() > 0){
			for (KeHuJueSeDO kehuJueSeDO : keHuJueSes) {
				JueSeQuanXianParam jueSeQuanXianParam=new JueSeQuanXianParam();
				jueSeQuanXianParam.setJueseid(kehuJueSeDO.getJueseid());
				List<JueSeQuanXianDO> jueSeQuanXians=jueSeQuanXianMapper.findList(jueSeQuanXianParam);
				if (null != jueSeQuanXians && jueSeQuanXians.size() > 0){
					for (JueSeQuanXianDO jueSeQuanXianDO : jueSeQuanXians) {
						authoritySet.add(new SimpleGrantedAuthority(jueSeQuanXianDO.getQuanxianmingcheng()));
					}
				}
			}
		}
		return authoritySet;
	}
}
