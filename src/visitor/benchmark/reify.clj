(ns visitor.benchmark.reify
  (:use [visitor.benchmark.bench]
        [visitor.benchmark.onto]))


(defn new-object-visitor []
  (reify org.semanticweb.owlapi.model.OWLObjectVisitor
    (^void visit [this
                  ^org.semanticweb.owlapi.model.OWLObjectProperty o])

    (^void visit [this
                  ^org.semanticweb.owlapi.model.OWLClass c])))


(defn reify-create []
  (bench (new-object-visitor)))


(defn reify-call-class []
  (let [v (new-object-visitor)]
    (bench (.visit v AClass))))


(defn reify-call-property []
  (let [v (new-object-visitor)]
    (bench (.visit v AProperty))))


(defn reify-call-class-hinted []
  (let [v (new-object-visitor)]
    (bench (.visit v ^org.semanticweb.owlapi.model.OWLClass AClass))))


(defn reify-call-property-hinted []
  (let [v (new-object-visitor)]
    (bench (.visit v ^org.semanticweb.owlapi.model.OWLObjectProperty AProperty))))


(defn run []
  (println "\nTesting reify create object")
  (reify-create)
  (println "\nAdd against OWL API methods")
  (reify-call-class)
  (reify-call-property)
  (println "\nAnd type hinted")
  (reify-call-class-hinted)
  (reify-call-property-hinted))
