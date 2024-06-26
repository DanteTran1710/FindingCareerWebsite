/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "recruitment")
public class Recruitment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecruitment;
    private String title;
    private String welfare;
    private String description;
    private String requirement;
    private String position;
    private String experience;
    private BigDecimal salary;
    private boolean now;
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = true
    )
    @JoinColumn(name = "idCompany")
    @JsonIgnore
    private Employer employer;
    @ManyToOne(
            optional = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "idCategory")
    @JsonIgnore
    private CategoryJob categoryJob;
    @OneToMany(mappedBy = "recruitment", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<CVsForRecruitments> cVsForRecruitmentses;
    @OneToMany(mappedBy = "recruitment", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<MostLikedRecruitment> mostLikeds;

    public Recruitment() {
    }

    public Recruitment(int idRecruitment, String title, String welfare, String description, String requirement, String position, String experience, BigDecimal salary, boolean now, Employer employer, CategoryJob categoryJob, List<CVsForRecruitments> cVsForRecruitmentses, List<MostLikedRecruitment> mostLikeds) {
        this.idRecruitment = idRecruitment;
        this.title = title;
        this.welfare = welfare;
        this.description = description;
        this.requirement = requirement;
        this.position = position;
        this.experience = experience;
        this.salary = salary;
        this.now = now;
        this.employer = employer;
        this.categoryJob = categoryJob;
        this.cVsForRecruitmentses = cVsForRecruitmentses;
        this.mostLikeds = mostLikeds;
    }

    /**
     * @return the idRecruitment
     */
    public int getIdRecruitment() {
        return idRecruitment;
    }

    /**
     * @param idRecruitment the idRecruitment to set
     */
    public void setIdRecruitment(int idRecruitment) {
        this.idRecruitment = idRecruitment;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the welfare
     */
    public String getWelfare() {
        return welfare;
    }

    /**
     * @param welfare the welfare to set
     */
    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the requirement
     */
    public String getRequirement() {
        return requirement;
    }

    /**
     * @param requirement the requirement to set
     */
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the experience
     */
    public String getExperience() {
        return experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     * @return the salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * @return the now
     */
    public boolean isNow() {
        return now;
    }

    /**
     * @param now the now to set
     */
    public void setNow(boolean now) {
        this.now = now;
    }

    /**
     * @return the employer
     */
    public Employer getEmployer() {
        return employer;
    }

    /**
     * @param employer the employer to set
     */
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    /**
     * @return the categoryJob
     */
    public CategoryJob getCategoryJob() {
        return categoryJob;
    }

    /**
     * @param categoryJob the categoryJob to set
     */
    public void setCategoryJob(CategoryJob categoryJob) {
        this.categoryJob = categoryJob;
    }

    /**
     * @return the cVsForRecruitmentses
     */
    public List<CVsForRecruitments> getcVsForRecruitmentses() {
        return cVsForRecruitmentses;
    }

    /**
     * @param cVsForRecruitmentses the cVsForRecruitmentses to set
     */
    public void setcVsForRecruitmentses(List<CVsForRecruitments> cVsForRecruitmentses) {
        this.cVsForRecruitmentses = cVsForRecruitmentses;
    }

    /**
     * @return the mostLikeds
     */
    public List<MostLikedRecruitment> getMostLikeds() {
        return mostLikeds;
    }

    /**
     * @param mostLikeds the mostLikeds to set
     */
    public void setMostLikeds(List<MostLikedRecruitment> mostLikeds) {
        this.mostLikeds = mostLikeds;
    }

}
