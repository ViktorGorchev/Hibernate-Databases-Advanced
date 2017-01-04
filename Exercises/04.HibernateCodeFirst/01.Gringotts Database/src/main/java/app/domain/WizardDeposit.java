package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit implements Serializable{

    @Transient
    private static final int MIN_MAGIC_WAND_SIZE = 1;

    @Transient
    private static final int MAX_MAGIC_WAND_SIZE = 32767;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(columnDefinition = "INT(11) UNSIGNED", nullable = false)
    private Integer age;

    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column(name = "magic_wand_size", columnDefinition = "SMALLINT UNSIGNED")
    private Integer magicWandSize;

    @Column(name = "deposit_group", length = 20)
    private String depositGroup;

    @Column(name = "deposit_start_date")
    private Date depositStartDate;

    @Column(name = "deposit_amount", columnDefinition = "DECIMAL")
    private BigDecimal depositAmount;

    @Column(name = "deposit_interest")
    private Double depositInterest;

    @Column(name = "deposit_charge", columnDefinition = "DECIMAL")
    private BigDecimal depositCharge;

    @Column(name = "deposit_expiration_date")
    private Date depositExpirationDate;

    @Column(name = "is_deposit_expired", columnDefinition = "TINYINT")
    private Boolean isDepositExpired;


    public WizardDeposit() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return this.magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public Integer getMagicWandSize() {
        return this.magicWandSize;
    }

    public void setMagicWandSize(Integer magicWandSize) {
        if(magicWandSize < MIN_MAGIC_WAND_SIZE || magicWandSize > MAX_MAGIC_WAND_SIZE){
            throw new IllegalArgumentException(
                    "Magic wand size not in Range from " + MIN_MAGIC_WAND_SIZE + " to " + MAX_MAGIC_WAND_SIZE);
        }

        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return this.depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public Date getDepositStartDate() {
        return this.depositStartDate;
    }

    public void setDepositStartDate(Date depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public BigDecimal getDepositAmount() {
        return this.depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Double getDepositInterest() {
        return this.depositInterest;
    }

    public void setDepositInterest(Double depositInterest) {
        this.depositInterest = depositInterest;
    }

    public BigDecimal getDepositCharge() {
        return this.depositCharge;
    }

    public void setDepositCharge(BigDecimal depositCharge) {
        this.depositCharge = depositCharge;
    }

    public Date getDepositExpirationDate() {
        return this.depositExpirationDate;
    }

    public void setDepositExpirationDate(Date depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public Boolean getDepositExpired() {
        return this.isDepositExpired;
    }

    public void setDepositExpired(Boolean depositExpired) {
        this.isDepositExpired = depositExpired;
    }
}