package com.cts.entities;


import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    public Inventory() {
    }

    public Inventory(Long invId, Integer count) {
        this.invId = invId;
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inv_id")
    private Long invId;

    @Column(name = "count")
    private Integer count;

    public Long getInvId() {
        return invId;
    }

    public void setInvId(Long invId) {
        this.invId = invId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "invId=" + invId +
                ", count=" + count +
                '}';
    }
}
