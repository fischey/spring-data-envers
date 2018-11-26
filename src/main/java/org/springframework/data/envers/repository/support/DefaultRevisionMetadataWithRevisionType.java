/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.envers.repository.support;

import java.time.LocalDateTime;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.springframework.data.history.RevisionMetadata;
import org.springframework.util.Assert;

/**
 * {@link RevisionMetadata} working with a {@link DefaultRevisionEntity} and {@link RevisionType}.
 *
 * @author Fischey
 */
public class DefaultRevisionMetadataWithRevisionType implements RevisionMetadata<Integer> {
	private final DefaultRevisionMetadata revisionMetadata;
	private final RevisionType revisionType;

	/**
	 * Creates a new {@link DefaultRevisionMetadataWithRevisionType}.
	 *
	 * @param revisionMetadata must not be {@literal null}
	 * @param revisionType     must not be {@literal null}
	 */
	public DefaultRevisionMetadataWithRevisionType(final DefaultRevisionMetadata revisionMetadata,
			final RevisionType revisionType) {
		Assert.notNull(revisionMetadata);
		Assert.notNull(revisionType);
		this.revisionMetadata = revisionMetadata;
		this.revisionType = revisionType;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.history.RevisionMetadata#getRevisionNumber()
	 */
	@Override
	public Integer getRevisionNumber() {
		return revisionMetadata.getRevisionNumber();
	}

	/*
		 * (non-Javadoc)
		 * @see org.springframework.data.history.RevisionMetadata#getRevisionNumber()
		 */
	@Override
	public LocalDateTime getRevisionDate() {
		return revisionMetadata.getRevisionDate();
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.history.RevisionMetadata#getDelegate()
	 */
	@Override
	public <T> T getDelegate() {
		return revisionMetadata.getDelegate();
	}

	public RevisionType getRevisionType() {
		return revisionType;
	}
}
