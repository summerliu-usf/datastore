package com.example.demo;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import java.util.List;

public interface ChapterRepository extends DatastoreRepository<Chapter, String> {
    Chapter getChapterById(int id);

}