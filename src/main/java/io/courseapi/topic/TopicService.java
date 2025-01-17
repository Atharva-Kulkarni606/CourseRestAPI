package io.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>( Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description")));
	
	//GET /topics Returns all the topics
	public List<Topic> getAllTopics() {
		return topics;
	}
	 
	//get /topics/id Returns a topic matching with id
	public Topic getTopic(String id) {
		return topics.stream().filter((topic) -> topic.getId().equals(id)).findFirst().get();
	}
	
	//POST /topics creates a new topic 
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	//PUT /topics/id Updates the topic with the id "id"
	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < topics.size(); i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
	
}
