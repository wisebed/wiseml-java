package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.enums.DataType;
import eu.wisebed.wiseml.merger.enums.Unit;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.parse.ParserCallback;
import eu.wisebed.wiseml.merger.internals.parse.ParserHelper;
import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.Capability;

public class CapabilityParser extends WiseMLElementParser<Capability> {

	public CapabilityParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		structure = new Capability();
		ParserHelper.parseStructures(reader, new ParserCallback(){
			@Override
			public void nextStructure(WiseMLTag tag, Object obj) {
				switch (tag) {
				case name:
					structure.setName((String)obj);
					break;
				case dataType:
					structure.setDataType((DataType)obj);
					break;
				case unit:
					structure.setUnit((Unit)obj);
					break;
				case capabilityDefaultValue:
					structure.setDefaultValue((String)obj);
					break;
				}
			}
		});
	}

}
