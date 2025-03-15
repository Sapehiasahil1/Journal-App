package com.sapehia.journalApp.controller;


import com.sapehia.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEnteries = new HashMap<>();

    @GetMapping()
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEnteries.values());
    }

    @PostMapping()
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEnteries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalById(@PathVariable long myId) {
        return journalEnteries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalById(@PathVariable long myId) {
        return journalEnteries.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable long id, @RequestBody JournalEntry newEntry) {
        journalEnteries.put(id, newEntry);
        return journalEnteries.get(id);
    }
}
