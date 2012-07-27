package eu.wisebed.wiseml.merger.internals.merge.elements;

import eu.wisebed.wiseml.merger.config.MergerConfiguration;
import eu.wisebed.wiseml.merger.internals.WiseMLSequence;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.merge.MergerResources;
import eu.wisebed.wiseml.merger.internals.merge.NamedItemListMerger;
import eu.wisebed.wiseml.merger.internals.merge.WiseMLTreeMerger;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class ScenarioListMerger extends NamedItemListMerger {

	protected ScenarioListMerger(
			final WiseMLTreeMerger parent,
			final WiseMLTreeReader[] inputs, 
			final MergerConfiguration configuration,
			final MergerResources resources) {
		super(
				parent, 
				inputs, 
				configuration, 
				resources, 
				WiseMLTag.scenario,
				WiseMLSequence.Scenario);
		this.mergingMode = this.configuration.getScenarioListMergingMode();
		this.customID = this.configuration.getCustomScenarioID();
	}

	@Override
	protected WiseMLTreeReader createMerger(
			WiseMLTreeReader[] inputs, String id) {
		return new ScenarioMerger(this, inputs, configuration, resources, id);
	}

}
