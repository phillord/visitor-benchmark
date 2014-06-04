(ns visitor.benchmark.protocol
  (:use [visitor.benchmark.bench]
        [visitor.benchmark.onto]))


(defprotocol Bob
  (protocolI [this]))

(deftype Fred [])

(extend-type Fred
  Bob
  (protocolI [this]))

(defn protocol-invoke []
  (let [fred (Fred.)]
    (bench (protocolI fred))))

(extend-type org.semanticweb.owlapi.model.OWLClass
  Bob
  (protocolI [this]))

(defn protocol-on-class []
  (bench (protocolI AClass)))

(extend-type org.semanticweb.owlapi.model.OWLObjectProperty
  Bob
  (protocolI [this]))

(defn protocol-on-property []
  (bench (protocolI AProperty)))

(defn run []
  (println "How fast is a simple protocol invoke?")
  (protocol-invoke)
  (println "Now try invoking against OWL API objects")
  (protocol-on-class)
  (protocol-on-property))
