package de.amit.battlequestOLD.controller.rest.topic;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.amit.battlequestOLD.model.Topic;

@RestController
@RequestMapping("/topic/manage")
public class TopicController {

	@GetMapping("/all")
	public List<Topic> getAllTopics() {
		return TopicLoader.getAll();
	}

	@GetMapping("/name={topicname}")
	public Topic getTopic(@PathVariable String topicName) {
		return TopicLoader.get(topicName);
	}

	@PutMapping("/name={topicname}")
	public void putTopic(@PathVariable String topicName, @RequestBody Topic topic) {
		if (topicExists(topicName))
			TopicModifier.modify(topicName, topic);
		else
			TopicSaver.save(topicName, topic);
	}

	private boolean topicExists(String topicName) {
		return true;
	}
}
