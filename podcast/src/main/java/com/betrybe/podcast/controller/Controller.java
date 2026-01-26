package com.betrybe.podcast.controller;

import com.betrybe.podcast.dto.PodcastCreationDto;
import com.betrybe.podcast.dto.PodcastDto;
import com.betrybe.podcast.model.Podcast;
import com.betrybe.podcast.service.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RequestMapping("/podcasts")
public class Controller {
  private PodcastService service;

  @Autowired
  public Controller(PodcastService service) {
    this.service = service;
  }

  @GetMapping
  public String getRoot() {
    return "Yay podcast";
  }

  @GetMapping("/{id}")
  public ResponseEntity<PodcastDto> getPodcast(@PathVariable Long id) {
    Podcast podcast = service.findPodcastById(id);
    if (podcast == null) {
      return ResponseEntity.notFound().build();
    }
    PodcastDto podcastDto = new PodcastDto(podcast.getId(), podcast.getName(), podcast.getUrl());
    return ResponseEntity.ok(podcastDto);
  }

  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return "Podcast : %s".formatted(title);
  }

  @PostMapping
  public ResponseEntity<PodcastDto> createPodcast(
      @RequestBody PodcastCreationDto podcastCreationDto) {
    Podcast newPodcast = new Podcast();
    newPodcast.setName(podcastCreationDto.name());
    newPodcast.setUrl(podcastCreationDto.url());

    Podcast savedPodcast = service.savePodcast(newPodcast);

    PodcastDto podcastDto =
        new PodcastDto(savedPodcast.getId(), savedPodcast.getName(), savedPodcast.getUrl());

    return ResponseEntity.status(HttpStatus.CREATED).body(podcastDto);
  }
}
