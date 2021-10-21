package orgFolder;

/**
 * 组织机构，
 */
public class Org {
    /**
     * id
     */
    private Integer id;
    /**
     * 组织名字
     */
    private String orgName;
    /**
     * 组织编号
     */
    private Integer orgCd;
    /**
     * 父级组织
     */
    private Integer parentId;

    public Org(Integer id, String orgName, Integer orgCd, Integer parentId) {
        this.id = id;
        this.orgName = orgName;
        this.orgCd = orgCd;
        this.parentId = parentId;
    }

    public Org() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgCd() {
        return orgCd;
    }

    public void setOrgCd(Integer orgCd) {
        this.orgCd = orgCd;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Org{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", orgCd=" + orgCd +
                ", parentId=" + parentId +
                '}';
    }
}
