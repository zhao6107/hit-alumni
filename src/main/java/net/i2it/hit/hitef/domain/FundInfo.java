package net.i2it.hit.hitef.domain;

public class FundInfo extends FundItemDO {

    private String typeName;//基金所属的类别名称

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "FundInfo{" +
                "typeName=" + typeName +
                "} " + super.toString();
    }

}
