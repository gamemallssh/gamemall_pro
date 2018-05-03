package module.manager_core.info.service.impl;

import javax.annotation.Resource;

import module.manager_core.info.dao.InfoDao;
import module.manager_core.info.entity.Info;
import module.manager_core.info.service.InfoService;

import org.springframework.stereotype.Service;

import core.service.impl.BaseServiceImpl;

@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {
	
	private InfoDao infoDao;
	@Resource public void setInfoDao(InfoDao infoDao) {
		super.setBaseDao(infoDao);
		this.infoDao = infoDao;
	}

}
