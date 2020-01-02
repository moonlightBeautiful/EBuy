package com.ims.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_smallType")
public class ProductSmallType {

    /**
     * Ψһ��ʶ
     */
    private int id;
    /**
     * ����
     */
    private String name;
    /**
     * ��ע
     */
    private String remarks;

    /**
     * ��Ʒ���࣬n��1
     */
    private ProductBigType bigType;
    /**
     * ��Ʒ��1��n
     */
    private List<Product> productList = new ArrayList<Product>();

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "bigTypeId")
    public ProductBigType getBigType() {
        return bigType;
    }

    public void setBigType(ProductBigType bigType) {
        this.bigType = bigType;
    }

    @OneToMany(mappedBy = "smallType")
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


}
