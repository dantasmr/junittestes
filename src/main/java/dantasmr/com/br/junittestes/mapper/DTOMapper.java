package dantasmr.com.br.junittestes.mapper;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DTOMapper {

	private final static ObjectMapper OBJECTMAPPER = new ObjectMapper();

	public <T> T parseDTO(Object objeto, TypeReference<T> reference) {

		try {
			String jsonObject = OBJECTMAPPER.writeValueAsString(objeto);
			return OBJECTMAPPER.readValue(jsonObject, reference);
		} catch (IOException io) {
			io.printStackTrace();
			return null;
		}

	}
}
