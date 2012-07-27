package eu.wisebed.wiseml.merger.internals.merge.elements;

import eu.wisebed.wiseml.merger.config.MergerConfiguration;
import eu.wisebed.wiseml.merger.internals.WiseMLAttribute;
import eu.wisebed.wiseml.merger.internals.WiseMLSequence;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.merge.MergerResources;
import eu.wisebed.wiseml.merger.internals.merge.WiseMLElementMerger;
import eu.wisebed.wiseml.merger.internals.merge.WiseMLTreeMerger;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class ScenarioMerger extends WiseMLElementMerger {

	public ScenarioMerger(
			final WiseMLTreeMerger parent, 
			final WiseMLTreeReader[] inputs,
			final MergerConfiguration configuration, 
			final MergerResources resources,
			final String id) {
		super(parent, inputs, configuration, resources, WiseMLTag.scenario);
		this.attributeList.add(new WiseMLAttribute("id", id));
	}

	@Override
	protected void fillQueue() {		
		WiseMLTreeReader[] inputs = 
			findSequenceReaders(WiseMLSequence.ScenarioItem);
		
		if (inputs != null) {
			queue.add(new ScenarioItemListMerger(
					this, 
					inputs, 
					configuration, 
					resources));
		}
	}
}
