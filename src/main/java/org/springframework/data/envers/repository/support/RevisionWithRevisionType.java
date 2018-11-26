package org.springframework.data.envers.repository.support;

import java.time.LocalDateTime;

import org.springframework.data.history.RevisionMetadata;
import org.springframework.util.Assert;

public class RevisionWithRevisionType<T> implements Comparable<RevisionWithRevisionType<?>> {
	private final DefaultRevisionMetadataWithRevisionType metadata;
	private final T entity;

	/**
	 * Creates a new {@link RevisionWithRevisionType} consisting of the given {@link DefaultRevisionMetadataWithRevisionType} and entity.
	 *
	 * @param metadata must not be {@literal null}.
	 * @param entity   must not be {@literal null}.
	 */
	public RevisionWithRevisionType(DefaultRevisionMetadataWithRevisionType metadata, T entity) {
		Assert.notNull(metadata);
		Assert.notNull(entity);

		this.metadata = metadata;
		this.entity = entity;
	}

	/**
	 * Returns the revision number of the revision.
	 *
	 * @return the revision number.
	 */
	public Integer getRevisionNumber() {
		return metadata.getRevisionNumber();
	}

	/**
	 * Returns the revision date of the revision.
	 *
	 * @return
	 */
	public LocalDateTime getRevisionDate() {
		return metadata.getRevisionDate();
	}

	/**
	 * Returns the underlying entity.
	 *
	 * @return the entity
	 */
	public T getEntity() {
		return entity;
	}

	/**
	 * Returns the {@link RevisionMetadata} for the current {@link DefaultRevisionMetadataWithRevisionType}.
	 *
	 * @return the metadata
	 */
	public DefaultRevisionMetadataWithRevisionType getMetadata() {
		return metadata;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(RevisionWithRevisionType<?> that) {
		return getRevisionNumber().compareTo(that.getRevisionNumber());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RevisionWithRevisionType)) {
			return false;
		}

		RevisionWithRevisionType<T> that = (RevisionWithRevisionType<T>) obj;
		boolean sameRevisionNumber = this.metadata.getRevisionNumber().equals(that.metadata.getRevisionNumber());
		return !sameRevisionNumber ? false : this.entity.equals(that.entity);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		int result = 17;
		result += 31 * metadata.hashCode();
		result += 31 * entity.hashCode();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Revision %s of entity %s - Revision metadata %s", getRevisionNumber(), entity, metadata);
	}
}
