package com.mygroup.inventorymanagementproject;

import java.io.Serializable;
import java.util.Objects;

public class AssignedToId implements Serializable {

    private String etcno;
    private String did;

    public AssignedToId() {}

    public AssignedToId(String etcno, String did) {
        this.etcno = etcno;
        this.did = did;
    }

    public String getEtcno() {
        return etcno;
    }

    public void setEtcno(String etcno) {
        this.etcno = etcno;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignedToId that = (AssignedToId) o;
        return Objects.equals(etcno, that.etcno) && Objects.equals(did, that.did);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etcno, did);
    }
}
