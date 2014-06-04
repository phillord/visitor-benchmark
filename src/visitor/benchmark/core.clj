(ns visitor.benchmark.core
  [:require [visitor.benchmark bench protocol multi reify
             cond map]]
  (:gen-class))


(defn f [])

(defn -main [& arg]
  (println "The baseline")
  (visitor.benchmark.bench/bench (f))

  (visitor.benchmark.protocol/run)
  (visitor.benchmark.multi/run)
  (visitor.benchmark.reify/run)
  (visitor.benchmark.cond/run)
  (visitor.benchmark.map/run))
