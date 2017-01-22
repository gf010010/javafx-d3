package org.treez.javafxd3.d3.selection.datafunction;

import org.treez.javafxd3.d3.core.Value;
import org.treez.javafxd3.d3.functions.DataFunction;

import org.treez.javafxd3.d3.core.JsEngine;
import org.treez.javafxd3.d3.core.JsObject;

/**
 * A datum function that returns the datum as integer array
 * 
 */
public class IntegerArrayDataFunction implements DataFunction<Integer[]> {
	
	//#region ATTRIBUTES
	
	private JsEngine engine;
	
	//#end region
	
	//#region CONSTRUCTORS
	
	/**
	 * @param engine
	 */
	public IntegerArrayDataFunction(JsEngine engine){
		this.engine=engine;
	}
	
	//#end region
	
	//#region METHODS

	@Override
	public Integer[] apply(Object context, Object datum, int index) {		
		JsObject jsObject = (JsObject) engine.toJsObjectIfNotSimpleType(datum);
		Value value = new Value(engine, jsObject);
		int[] intArray = value.as();		
		Integer[] integerObjectArray = convertToIntegerArray(intArray);		
		return integerObjectArray;		
	}

	private Integer[] convertToIntegerArray(int[] intArray) {
		Integer[] integerArray = new Integer[intArray.length];
		int i = 0;
		for (int intValue : intArray) {
		    integerArray[i++] = Integer.valueOf(intValue);
		}
		return integerArray;
	}
	
	//#end region

}
