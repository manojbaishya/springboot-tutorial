package com.dailycodebuffer.springboot.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotBlank(message = "Department Name cannot be empty.")
    private String departmentName;
    private String departmentAddress;

    @Length(min = 0, max = 50)
    private String departmentCode;

    /**
     * @param departmentId
     * @param departmentName
     * @param departmentAddress
     * @param departmentCode
     */

    public Department() {
    }

    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.setDepartmentId(departmentId);
        this.setDepartmentName(departmentName);
        this.setDepartmentAddress(departmentAddress);
        this.setDepartmentCode(departmentCode);
    }

    /**
     * @return the departmentId
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the departmentAddress
     */
    public String getDepartmentAddress() {
        return departmentAddress;
    }

    /**
     * @param departmentAddress the departmentAddress to set
     */
    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    /**
     * @return the departmentCode
     */
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * @param departmentCode the departmentCode to set
     */
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return String.format("Department [departmentId=%s, departmentName=%s, departmentAddress=%s, departmentCode=%s]",
                departmentId, departmentName, departmentAddress, departmentCode);
    }

    public Department(Builder builder) {
        this.setDepartmentId(builder.departmentId);
        this.setDepartmentName(builder.departmentName);
        this.setDepartmentAddress(builder.departmentAddress);
        this.setDepartmentCode(builder.departmentCode);
    }

    public static Builder builder(Long departmentId) {
        return new Builder(departmentId);
    }

    public static class Builder {
        private Long departmentId = null;
        private String departmentName = null;
        private String departmentAddress = null;
        private String departmentCode = null;

        Builder(Long departmentId) {
            this.departmentId = departmentId;
        }

        public Builder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder departmentAddress(String departmentAddress) {
            this.departmentAddress = departmentAddress;
            return this;
        }

        public Builder departmentCode(String departmentCode) {
            this.departmentCode = departmentCode;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}
