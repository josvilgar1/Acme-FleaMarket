
package acme.entities.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpamUtils {

	private static final String	REGEX	= "[\\W]+";

	@Autowired
	private SpamRepository		repository;

	private Spam				spam;

	private List<String>		spamWords;

	private Double				count;


	public void init() {
		spam = repository.findManyAll().iterator().next();
		count = 0d;
		spamWords = Arrays.asList(spam.getWords().toLowerCase().split(","))
			.stream()
			.map(m -> m.trim())
			.collect(Collectors.toList());
	}

	public synchronized Boolean checkSpam(final String text) {
		String[] splitText = text.toLowerCase().split(SpamUtils.REGEX);
		int length = splitText.length;
		Double max = length * (spam.getThreshold() / 100);

		Arrays.asList(splitText).parallelStream().forEach(t -> {
			if (spamWords.contains(t.trim()))
				count++;
		});
		Double aux = count;
		resetCount();
		return aux > max;
	}

	public Double getThreshold() {
		return spam.getThreshold();
	}

	private void resetCount() {
		count = 0d;
	}

	public List<String> getSpamWords() {
		return spamWords;
	}

	public void setSpam(final Spam entity) {
		spam = entity;
		count = 0d;
		if (spam.getWords() != ",")
			spamWords = Arrays.asList(spam.getWords().split(","))
				.stream()
				.map(m -> m.trim())
				.collect(Collectors.toList());
	}
}
