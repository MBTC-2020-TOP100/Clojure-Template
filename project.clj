(defproject clojure-submission "0.1.0-SNAPSHOT"
  :description "Clojure app to final challge on Maratona Behind The Code"
  :author "Joao Pedro Poloni Ponce"
  :email "poloniponce@protonmail.ch"
  :url "https://github.com/MBTC-2020-TOP100/Clojure-Template"
  :license {:name "Apache-2.0 License "
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-http "3.10.3"]
                 [cheshire "5.6.1"]
                 [org.clojure/data.json "1.0.0"]]
  :main ^:skip-aot clojure-submission.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
