package eu.wisebed.wiseml.merger.internals.parse.elements;

import eu.wisebed.wiseml.merger.enums.DataType;
import eu.wisebed.wiseml.merger.enums.Unit;
import eu.wisebed.wiseml.merger.internals.parse.WiseMLElementParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReaderHelper;
import eu.wisebed.wiseml.merger.structures.RSSI;

public class RSSIParser extends WiseMLElementParser<RSSI> {

	public RSSIParser(WiseMLTreeReader reader) {
		super(reader);
	}

	@Override
	protected void parseStructure() {
		structure = new RSSI();
		structure.setDataType(DataType.valueOf(
				WiseMLTreeReaderHelper.getAttributeValue(
						reader.getAttributeList(), "datatype")));
		structure.setUnit(Unit.valueOf(
				WiseMLTreeReaderHelper.getAttributeValue(
						reader.getAttributeList(), "unit")));
		structure.setDefaultValue(
				WiseMLTreeReaderHelper.getAttributeValue(
						reader.getAttributeList(), "default"));
	}

}
