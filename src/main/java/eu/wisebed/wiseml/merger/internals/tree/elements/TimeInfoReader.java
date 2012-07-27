package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.TimeInfo;

public class TimeInfoReader extends WiseMLStructureReader {

	public TimeInfoReader(
			final WiseMLTreeReader parent, 
			final TimeInfo timeInfo) {
		super(new Element(parent, WiseMLTag.timeinfo, null, new Element[]{
				createPureTextElement(
						null, 
						WiseMLTag.start, 
						timeInfo.getStart().toString()),
				((timeInfo.isEndDefined())?
						createPureTextElement(
								null,
								WiseMLTag.end,
								timeInfo.getEnd().toString())
						:
						createPureTextElement(
								null,
								WiseMLTag.duration,
								Long.toString(timeInfo.getDuration()))),
				createPureTextElement(
						null,
						WiseMLTag.unit,
						timeInfo.getUnit().name())
		}, null));
	}

}
