package net.betterplayer.auth;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R> extends Function<T, R> {

	@Override
	default R apply(final T elem) {
		try {
			return acceptThrows(elem);
		} catch(final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	R acceptThrows(T elem) throws Exception;	
}