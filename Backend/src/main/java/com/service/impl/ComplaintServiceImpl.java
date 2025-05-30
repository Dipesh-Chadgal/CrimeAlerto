package com.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dto.ComplaintDTO;
import com.entity.Citizen;
import com.entity.Complaint;
import com.mapper.ComplaintMapper;
import com.repository.ComplaintRepository;
import com.service.CitizenService;
import com.service.ComplaintService;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintRepository complaintRepository;
    private ComplaintMapper complaintMapper;
    private CitizenService citizenService;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository, ComplaintMapper complaintMapper,CitizenService citizenService) {
        this.complaintRepository = complaintRepository;
        this.complaintMapper = complaintMapper;
        this.citizenService = citizenService;
    }

    @Override
    public void addComplaint(ComplaintDTO complaintDTO) {
        Complaint complaint = complaintMapper.toEntity(complaintDTO);
        complaintRepository.save(complaint);
    }

    @Override
    public List<ComplaintDTO> findAllComplaints() {
        return complaintRepository.findAll()
                .stream()
                .map(complaintMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComplaintDTO> findAllComplaintsCitizenId(Long citizenId) {
        Citizen citizen = citizenService.findById(citizenId).orElseThrow(() -> new RuntimeException("User Not Found"));
        return complaintRepository.fetchComplaintWhereCitizenId(citizen)
                .stream()
                .map(complaintMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ComplaintDTO getComplaintById(Integer complaintId) {

        Complaint complaint = complaintRepository.getByComplaintId(complaintId).orElseThrow(() -> new RuntimeException("No Complaint found it ID : " + complaintId));

        return complaintMapper.toDTO(complaint);
    }

    @Override
    public String getUploadedDocument(Integer complaintId) {
       String uploadedDocumentUrl = complaintRepository.getUploadedDocument(complaintId).orElseThrow(() -> new RuntimeException("Error in fetching the document"));
        
       return uploadedDocumentUrl.toString();
    }

    
}
