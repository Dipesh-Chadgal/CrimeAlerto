package com.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Law_Enforcement")
public class LawEnforcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UUID")
    private Integer uuid;

    @Column(name = "police_station_name", nullable = false)
    private String policeStationName;

    @Column(name = "police_station_email", nullable = false, unique = true)
    private String policeStationEmail;

    @Column(name = "police_station_contactNo", nullable = false)
    private Integer policeStationContactNo;

    @Column(name = "SHO", nullable = false)
    private String sho;

    @Column(name = "Address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> assignedComplaints;

    // Getters and Setters
    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getPoliceStationName() {
        return policeStationName;
    }

    public void setPoliceStationName(String policeStationName) {
        this.policeStationName = policeStationName;
    }

    public String getPoliceStationEmail() {
        return policeStationEmail;
    }

    public void setPoliceStationEmail(String policeStationEmail) {
        this.policeStationEmail = policeStationEmail;
    }

    public Integer getPoliceStationContactNo() {
        return policeStationContactNo;
    }

    public void setPoliceStationContactNo(Integer policeStationContactNo) {
        this.policeStationContactNo = policeStationContactNo;
    }

    public String getSho() {
        return sho;
    }

    public void setSho(String sho) {
        this.sho = sho;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Complaint> getAssignedComplaints() {
        return assignedComplaints;
    }

    public void setAssignedComplaints(List<Complaint> assignedComplaints) {
        this.assignedComplaints = assignedComplaints;
    }
}