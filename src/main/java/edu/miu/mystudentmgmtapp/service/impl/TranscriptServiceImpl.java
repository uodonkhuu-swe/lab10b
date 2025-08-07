package edu.miu.mystudentmgmtapp.service.impl;

import edu.miu.mystudentmgmtapp.model.Transcript;
import edu.miu.mystudentmgmtapp.repository.TranscriptRepository;
import edu.miu.mystudentmgmtapp.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {
    private TranscriptRepository transcriptRepository;

    @Autowired
    public void setTranscriptRepository(TranscriptRepository transcriptRepository){
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public Transcript addTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }
}
