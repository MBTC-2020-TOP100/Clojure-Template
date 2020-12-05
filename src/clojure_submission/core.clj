(ns clojure-submission.core
  (:gen-class)
  (:require [clj-http.client :as http]
            [clojure.data.json :as json]))

(defn submission [payload]
  (def url "http://172.21.86.186:5000/submit")
  (let [resp (http/post url {
        :body (json/write-str {
          :email_addr (System/getenv "EMAIL_USER")
          :wml_url (System/getenv "WML_URL")
          :submit_confirmation false
          :iam_token payload
        })
        :content-type :json
      })]
      (println resp)))

(defn get_token [token]
  (def payload ((json/read-str (get token :body)) "access_token"))
  (submission payload))

(defn request_token []
  (let [result (http/post "https://iam.cloud.ibm.com/identity/token" {
        :form-params {
          :apikey (System/getenv "APIKEY")
          :grant_type "urn:ibm:params:oauth:grant-type:apikey"
        }})]
    (get_token result)))

(defn -main [& args]
  (println "Clojure app started")
  (request_token)
  (println "Submited check the logs above to confirm")
  (while true))
