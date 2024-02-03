/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.ml4j.openai.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author Michael Lavelle
 * @param <C>
 */
public class GPTResponseBase<C> implements Serializable {

	/**
	 * Default serialization id.
	 */
	protected static final long serialVersionUID = 1L;

	protected String id;
	protected String object;

	protected long created;

	protected String model;

	protected Usage usage;

	public String getId() {
		return id;
	}

	public String getObject() {
		return object;
	}


	public long getCreated() {
		return created;
	}


	public String getModel() {
		return model;
	}

	public Usage getUsage() {
		return usage;
	}

	protected List<C> choices;

	public List<C> getChoices() {
		return choices;
	}

	@Override
	public String toString() {
		return "GPT3Response{" +
				"id='" + id + '\'' +
				", object='" + object + '\'' +
				", created=" + created +
				", model='" + model + '\'' +
				", usage=" + usage +
				", choices=" + choices +
				'}';
	}
}
