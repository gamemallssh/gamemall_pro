package module.manager_mall.goods.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * MmGoodstype entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class MmGoodstype implements java.io.Serializable {

	// Fields

	private String gtId;
	private MmGoodstype mmGoodstype;
	private String gtName;
	private String gtDesc;
	private Set mmGoodstypes = new HashSet(0);
	private Set mmGoodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public MmGoodstype() {
	}

	/** full constructor */
	public MmGoodstype(MmGoodstype mmGoodstype, String gtName, String gtDesc,
			Set mmGoodstypes, Set mmGoodses) {
		this.mmGoodstype = mmGoodstype;
		this.gtName = gtName;
		this.gtDesc = gtDesc;
		this.mmGoodstypes = mmGoodstypes;
		this.mmGoodses = mmGoodses;
	}

	// Property accessors

	public String getGtId() {
		return this.gtId;
	}

	public void setGtId(String gtId) {
		this.gtId = gtId;
	}

	public MmGoodstype getMmGoodstype() {
		return this.mmGoodstype;
	}

	public void setMmGoodstype(MmGoodstype mmGoodstype) {
		this.mmGoodstype = mmGoodstype;
	}

	public String getGtName() {
		return this.gtName;
	}

	public void setGtName(String gtName) {
		this.gtName = gtName;
	}

	public String getGtDesc() {
		return this.gtDesc;
	}

	public void setGtDesc(String gtDesc) {
		this.gtDesc = gtDesc;
	}

	public Set getMmGoodstypes() {
		return this.mmGoodstypes;
	}

	public void setMmGoodstypes(Set mmGoodstypes) {
		this.mmGoodstypes = mmGoodstypes;
	}

	public Set getMmGoodses() {
		return this.mmGoodses;
	}

	public void setMmGoodses(Set mmGoodses) {
		this.mmGoodses = mmGoodses;
	}

}