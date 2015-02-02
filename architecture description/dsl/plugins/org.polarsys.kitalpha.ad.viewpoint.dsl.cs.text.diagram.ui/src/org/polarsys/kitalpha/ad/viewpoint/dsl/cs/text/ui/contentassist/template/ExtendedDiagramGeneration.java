package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.contentassist.template;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.contentassist.acceleration.DiagramTextAcceleration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.contentassist.output.TreeAppendable;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.ui.internal.VpdiagramActivator;

public class ExtendedDiagramGeneration implements IGenerationStrategy {

	private EObject model;
	private IQualifiedNameProvider qualifiedNameProvider;
	
	
	public ExtendedDiagramGeneration(EObject model, IQualifiedNameProvider qualifiedNameProvider){
		this.qualifiedNameProvider = qualifiedNameProvider;
		this.model = model;
	}
	
	@Override
	public TreeAppendable generateDiagram(Class vpClass) {
		TreeAppendable appendable = new TreeAppendable(model, IGenerationStrategy.INDENTATION, IGenerationStrategy.LINE_SEPARATOR);
		
		DiagramTextAcceleration diagramTextAcceleration = 
				new DiagramTextAcceleration(vpClass, qualifiedNameProvider, appendable, vpClass.getName());
		
		long suffix = VpdiagramActivator.getAndIncrementDiagram_suffix();
		
		appendable.append("DiagramExtension \"diagramExtension_" + suffix + "\" {");
		appendable.increaseIndentation().newLine();
		appendable.append("extended-diagram: ").append("//extended diagram"); //TODO resolver
		appendable.newLine();
		appendable.append("Mapping {");
		appendable.increaseIndentation().newLine();
		
		if (diagramTextAcceleration.isRootNodesEmpty()){
			//Create node
			createNode(appendable, vpClass, diagramTextAcceleration);
		} else {
			createContainer(appendable, vpClass, diagramTextAcceleration);
		}
		diagramTextAcceleration.generateNodesText();
		
		appendable.decreaseIndentation().newLine();
		appendable.append("}"); //contains
		appendable.decreaseIndentation().newLine();
		appendable.append("}"); //container or node
		diagramTextAcceleration.generateEdgesText();
		appendable.decreaseIndentation().newLine();
		appendable.append("}"); //Mapping
		appendable.newLine();
		appendable.append("Actions {");
		
		generateActionRootExtendDiagramNode(appendable, vpClass);
		diagramTextAcceleration.generateActionsText();
		
		appendable.decreaseIndentation().newLine();
		appendable.append("}");
		
		return appendable;
	}
	
	private void createNode(TreeAppendable appendable, Class domainContext, DiagramTextAcceleration acceleration){
		appendable.append("Node ").append(domainContext.getName()).append("{");
		appendable.increaseIndentation().newLine();
		appendable.append("import: ").append("//import a node");
		appendable.newLine();
		appendable.append("domain-context: ").append(qualifiedNameProvider.apply(domainContext).toString());
		appendable.newLine();
		//TODO provided by association with variable resolver?
		appendable.append("provided-by association external emde.ExtensibleElement.ownedExtensions");
		appendable.newLine();
		acceleration.generateRepresentation("\"feature:name\"", true);
		appendable.newLine();
		appendable.append("Contains {");
		appendable.increaseIndentation().newLine();
		
		
	}
	
	private void createContainer(TreeAppendable appendable, Class domainContext, DiagramTextAcceleration acceleration){
		appendable.append("Container ").append(domainContext.getName()).append("{");
		appendable.increaseIndentation().newLine();
		appendable.append("import: ").append("//import a node");
		appendable.newLine();
		appendable.append("domain-context: ").append(qualifiedNameProvider.apply(domainContext).toString());
		appendable.newLine();
		//TODO provided by association with variable resolver?
		appendable.append("provided-by association external emde.ExtensibleElement.ownedExtensions");
		appendable.newLine();
		acceleration.generateRepresentation("\"ContainerLabel\"", false);
		appendable.newLine();
		appendable.append("Contains {");
		appendable.increaseIndentation().newLine();
	}
	
	
	private void generateActionRootExtendDiagramNode(TreeAppendable appendable, Class domainContext){
		long suffix = VpdiagramActivator.getAndIncrementDiagram_suffix();
		
		appendable.increaseIndentation().newLine();
		appendable.append("/* ").append(domainContext.getName()).append(" Actions*/").newLine();
		appendable.append("Create ").append(domainContext.getName().trim()).append("_CT_" + suffix).append("{");
		appendable.increaseIndentation().newLine();
		appendable.append("label: \"").append(domainContext.getName()).append("\" ");
		appendable.append("action-for: ").append(domainContext.getName().trim());
		appendable.decreaseIndentation().newLine();
		appendable.append("}");
		appendable.decreaseIndentation();
	}
}