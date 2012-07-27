package eu.wisebed.wiseml.merger.internals.merge.elements;

import eu.wisebed.wiseml.merger.config.MergerConfiguration;
import eu.wisebed.wiseml.merger.internals.WiseMLSequence;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.merge.MergerResources;
import eu.wisebed.wiseml.merger.internals.merge.NamedItemListMerger;
import eu.wisebed.wiseml.merger.internals.merge.WiseMLTreeMerger;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

public class TraceListMerger extends NamedItemListMerger {

	public TraceListMerger(
			final WiseMLTreeMerger parent,
			final WiseMLTreeReader[] inputs, 
			final MergerConfiguration configuration,
			final MergerResources resources) {
		super(
				parent, 
				inputs, 
				configuration, 
				resources, 
				WiseMLTag.trace,
				WiseMLSequence.Trace);
		this.mergingMode = this.configuration.getTraceListMergingMode();
		this.customID = this.configuration.getCustomTraceID();
	}

	@Override
	protected WiseMLTreeReader createMerger(
			WiseMLTreeReader[] inputs, String id) {
		return new TraceMerger(this, inputs, configuration, resources, id);
	}

}
