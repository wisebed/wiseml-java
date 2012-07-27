package eu.wisebed.wiseml.merger.internals.merge;

public abstract class Transformer<T> {
	
	public abstract T transform(final T input, final int inputIndex);

}
