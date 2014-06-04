(ns visitor.benchmark.cond
  (:use [visitor.benchmark.bench]
        [visitor.benchmark.onto]))

(defn small [e]
  (cond
   (instance? org.semanticweb.owlapi.model.OWLClass e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectProperty e)
   true))

(defn cond-small-on-class []
  (bench (small AClass)))

(defn cond-small-on-property []
  (bench (small AProperty)))

(defn big [e]
  (cond
   (instance? org.semanticweb.owlapi.model.IRI e)
   true
   (instance? org.semanticweb.owlapi.model.OWLIndividual e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectOneOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectUnionOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectIntersectionOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectAllValuesFrom e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectComplementOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectExactCardinality e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectMaxCardinality e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectMinCardinality e)
   true
   (instance? org.semanticweb.owlapi.model.OWLAnnotation e)
   true
   (instance? org.semanticweb.owlapi.model.OWLAnnotationProperty e)
   true
   (instance? org.semanticweb.owlapi.model.OWLAnnotationValue e)
   true
   (instance? org.semanticweb.owlapi.model.OWLLiteral e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataSomeValuesFrom e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataAllValuesFrom e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataComplementOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataUnionOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataIntersectionOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataExactCardinality e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataMaxCardinality e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataMinCardinality e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataOneOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDatatypeRestriction e)
   true
   (instance? org.semanticweb.owlapi.model.OWLFacetRestriction e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDatatype e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectHasValue e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectHasSelf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLDataHasValue e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectInverseOf e)
   true
   (instance? org.semanticweb.owlapi.model.OWLClass e)
   true
   (instance? org.semanticweb.owlapi.model.OWLObjectProperty e)
   true
   ))

(defn cond-big-on-class []
  (bench (big AClass)))

(defn cond-big-on-property []
  (bench (big AProperty)))


(defn run []
  (println "\nSimple cond small")
  (cond-small-on-class)
  (cond-small-on-property)
  (println "\nSimple cond large")
  (cond-big-on-class)
  (cond-big-on-property))
