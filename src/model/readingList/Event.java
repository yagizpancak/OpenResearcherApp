package model.readingList;

public class Event {
	private EventType eventType;
	private Object argument;

	public Event(EventType eventType, Object argument) {
		this.eventType = eventType;
		this.argument = argument;
	}

	public EventType getEventType() {
		return eventType;
	}

	public Object getArgument() {
		return argument;
	}
}

