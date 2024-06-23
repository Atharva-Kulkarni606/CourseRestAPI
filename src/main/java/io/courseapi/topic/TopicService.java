package io.courseapi.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description"));
	
	//GET /topics Returns all the topics
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	//get /Topics/id Returns a topic matching with id
	public Topic getTopic(String id) {
		return topics.stream().filter((topic) -> topic.getId().equals(id)).findFirst().get();
	}
	
}
