package com.sony.bigcommerce.demo.converters;
@FunctionalInterface
public interface IConvertrs<FROM, TO> {
	TO convert(FROM from );

}
