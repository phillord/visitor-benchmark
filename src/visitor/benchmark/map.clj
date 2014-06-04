(ns visitor.benchmark.map
  (:use [visitor.benchmark.bench]
        [visitor.benchmark.onto]))

(defn class-compare
  [this that]
  (cond
   (isa? this that)
   -1
   (isa? that this)
   1
   :default 0))

(defn lookup
  [c]
  (first
   (filter
    (fn lookup [parent]
      (isa? c parent))
    (list org.semanticweb.owlapi.model.OWLClass
          org.semanticweb.owlapi.model.OWLObjectProperty
          org.semanticweb.owlapi.model.OWLNamedIndividual
          org.semanticweb.owlapi.model.OWLDataProperty
          org.semanticweb.owlapi.model.OWLAnnotationProperty
          org.semanticweb.owlapi.model.OWLDatatype))))

(def mlookup (memoize lookup))

(def invoke-map
  {org.semanticweb.owlapi.model.OWLClass true
   org.semanticweb.owlapi.model.OWLObjectProperty true})

(defn get-f [entity]
  (get invoke-map (mlookup (class entity))))

(defn map-small-on-class []
  (bench (get-f AClass)))

(defn map-small-on-property []
  (bench (get-f AProperty)))


(def big-lookup-list
  (sort
   class-compare
   (list
    org.semanticweb.owlapi.model.IRI
    org.semanticweb.owlapi.model.OWLClass
    org.semanticweb.owlapi.model.OWLProperty
    org.semanticweb.owlapi.model.OWLIndividual
    org.semanticweb.owlapi.model.OWLObjectOneOf
    org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom
    org.semanticweb.owlapi.model.OWLObjectUnionOf
    org.semanticweb.owlapi.model.OWLObjectIntersectionOf
    org.semanticweb.owlapi.model.OWLObjectAllValuesFrom
    org.semanticweb.owlapi.model.OWLObjectComplementOf
    org.semanticweb.owlapi.model.OWLObjectExactCardinality
    org.semanticweb.owlapi.model.OWLObjectMaxCardinality
    org.semanticweb.owlapi.model.OWLObjectMinCardinality
    org.semanticweb.owlapi.model.OWLAnnotation
    org.semanticweb.owlapi.model.OWLAnnotationProperty
    org.semanticweb.owlapi.model.OWLAnnotationValue
    org.semanticweb.owlapi.model.OWLLiteral
    org.semanticweb.owlapi.model.OWLDataSomeValuesFrom
    org.semanticweb.owlapi.model.OWLDataAllValuesFrom
    org.semanticweb.owlapi.model.OWLDataComplementOf
    org.semanticweb.owlapi.model.OWLDataUnionOf
    org.semanticweb.owlapi.model.OWLDataIntersectionOf
    org.semanticweb.owlapi.model.OWLDataExactCardinality
    org.semanticweb.owlapi.model.OWLDataMaxCardinality
    org.semanticweb.owlapi.model.OWLDataMinCardinality
    org.semanticweb.owlapi.model.OWLDataOneOf
    org.semanticweb.owlapi.model.OWLDatatypeRestriction
    org.semanticweb.owlapi.model.OWLFacetRestriction
    org.semanticweb.owlapi.model.OWLDatatype
    org.semanticweb.owlapi.model.OWLObjectHasValue
    org.semanticweb.owlapi.model.OWLObjectHasSelf
    org.semanticweb.owlapi.model.OWLDataHasValue
    org.semanticweb.owlapi.model.OWLObjectInverseOf)))

(defn big-lookup
  [c]
  (first
   (filter
    (fn [parent]
      (isa? c parent))
    big-lookup-list)))

(def m-big-lookup (memoize big-lookup))

(def invoke-big-map
  (apply hash-map
         (interleave big-lookup-list
                     (repeat true))))

(defn get-big-f [entity]
  (get invoke-map (m-big-lookup (class entity))))


(defn map-big-on-class[]
  (bench (get-big-f AClass)))

(defn map-big-on-property[]
  (bench (get-big-f AProperty)))


(defn run []
  (println "\nSmall map lookup")
  (map-small-on-class)
  (map-small-on-property)
  (println "\nLarge map lookup")
  (map-big-on-class)
  (map-big-on-property))
