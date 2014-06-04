(defproject visitor-benchmark "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [uk.org.russet/tawny-owl "1.1.0"]
                 [criterium "0.4.3"]]

  :main visitor.benchmark.core
  :profiles
  {
   :3.5.0
   [:production
    {:dependencies [[net.sourceforge.owlapi/owlapi-distribution "3.5.0"]]}]

   :3.4.10
   [:production
    {:dependencies [[net.sourceforge.owlapi/owlapi-distribution "3.4.10"]]}]
})
