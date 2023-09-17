package com.example.client.clientel.atithi;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AtithiService {

	private AtithiRepository atithiRepository;
	
	@Autowired
	public AtithiService(AtithiRepository atithiRepository) {
		this.atithiRepository = atithiRepository;
	}
	
	public List<Atithi> getAtithis() {
		return this.atithiRepository.findAll();
	}
	
	public void addNewAtithi(Atithi atithi) throws IllegalStateException {
		Optional<Atithi> atithiById = this.atithiRepository.findAtithiById(atithi.getId());
		if (atithiById.isPresent()) {
			throw new IllegalStateException("Atithi taken!");
		}
		this.atithiRepository.save(atithi);
	}
	
	public void deleteAtithi(String id) {
		boolean exists = this.atithiRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException(
					"Student with id " + id + " does not exist!"
			);
		}
		this.atithiRepository.deleteById(id);
	}

	@Transactional
	public void updateAtithi(String id, String name, String plan, String token) {
		Atithi atithi = this.atithiRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(
						"Student with id " + id + " does not exist!"
					));
		if (name != null && name.length() > 0 && !Objects.equals(atithi.getName(), name)) {
				atithi.setName(name);
		}

		if (plan != null && plan.length() > 0 && !Objects.equals(atithi.getPlan(), plan)) {
			atithi.setPlan(plan);
		}

		if (token != null && token.length() > 0 && !Objects.equals(atithi.getToken(), token)) {
			atithi.setToken(token);
		}
	}
}
