package module.manager_mall.goods.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * MmGoods entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class MmGoods implements java.io.Serializable {

	// Fields

	private String goodsId;
	private MmGoodstype mmGoodstype;
	private String goodsName;
	private String goodsMemo;
	private String goodsPublisher;
	private String goodsStatus;
	private Double goodsPrice;
	private Double goodsDiscount;
	private Timestamp goodsPublishtime;
	private String goodsCreator;
	private Set mmImageses = new HashSet(0);

	// Constructors

	/** default constructor */
	public MmGoods() {
	}

	/** minimal constructor */
	public MmGoods(MmGoodstype mmGoodstype) {
		this.mmGoodstype = mmGoodstype;
	}

	/** full constructor */
	public MmGoods(MmGoodstype mmGoodstype, String goodsName, String goodsMemo,
			String goodsPublisher, String goodsStatus, Double goodsPrice,
			Double goodsDiscount, Timestamp goodsPublishtime,
			String goodsCreator, Set mmImageses) {
		this.mmGoodstype = mmGoodstype;
		this.goodsName = goodsName;
		this.goodsMemo = goodsMemo;
		this.goodsPublisher = goodsPublisher;
		this.goodsStatus = goodsStatus;
		this.goodsPrice = goodsPrice;
		this.goodsDiscount = goodsDiscount;
		this.goodsPublishtime = goodsPublishtime;
		this.goodsCreator = goodsCreator;
		this.mmImageses = mmImageses;
	}

	// Property accessors

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public MmGoodstype getMmGoodstype() {
		return this.mmGoodstype;
	}

	public void setMmGoodstype(MmGoodstype mmGoodstype) {
		this.mmGoodstype = mmGoodstype;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsMemo() {
		return this.goodsMemo;
	}

	public void setGoodsMemo(String goodsMemo) {
		this.goodsMemo = goodsMemo;
	}

	public String getGoodsPublisher() {
		return this.goodsPublisher;
	}

	public void setGoodsPublisher(String goodsPublisher) {
		this.goodsPublisher = goodsPublisher;
	}

	public String getGoodsStatus() {
		return this.goodsStatus;
	}

	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Double getGoodsDiscount() {
		return this.goodsDiscount;
	}

	public void setGoodsDiscount(Double goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}

	public Timestamp getGoodsPublishtime() {
		return this.goodsPublishtime;
	}

	public void setGoodsPublishtime(Timestamp goodsPublishtime) {
		this.goodsPublishtime = goodsPublishtime;
	}

	public String getGoodsCreator() {
		return this.goodsCreator;
	}

	public void setGoodsCreator(String goodsCreator) {
		this.goodsCreator = goodsCreator;
	}

	public Set getMmImageses() {
		return this.mmImageses;
	}

	public void setMmImageses(Set mmImageses) {
		this.mmImageses = mmImageses;
	}

}