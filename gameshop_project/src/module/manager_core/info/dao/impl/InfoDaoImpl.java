package module.manager_core.info.dao.impl;

import org.springframework.stereotype.Repository;

import module.manager_core.info.dao.InfoDao;
import module.manager_core.info.entity.Info;
import core.dao.impl.BaseDaoImpl;

@Repository("infoDao")
public class InfoDaoImpl extends BaseDaoImpl<Info> implements InfoDao {

}
