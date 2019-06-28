(ns bloggo.lambda.core
  (:require [bloggo.lambda.util :as util]
            [clojure.string :as str]
            [cljs-node-io.core :as io :refer [slurp spit]]
            [cljs.reader :as reader]))

(def page-length 1)

(def mock-posts (reader/read-string (slurp "resources/posts.edn")))

(defn post->preview [post]
  (update post :post (fn [post-content]
                       (-> post-content
                           (str/split #"\n")
                           first))))

(defn posts->previews [posts]
  (map post->preview posts))

(defn split-to-pages [posts page-length]
  (partition page-length page-length nil posts))

(defn posts-response-body [posts page-count]
  {:page-count page-count
   :posts posts})

(defn posts [e ctx cb]
  (let [path-params (-> e util/clojurify-event :path-parameters)
        pages (split-to-pages mock-posts page-length)]
    (cb nil (clj->js {:statusCode 200
                      :body (-> pages
                                (nth (dec (int (:page path-params))) nil)
                                posts->previews
                                (posts-response-body (count pages))
                                clj->js
                                js/JSON.stringify)}))))

(defn post [e ctx cb]
  (let [post-id (-> e util/clojurify-event :path-parameters :id int)]
    (cb nil (clj->js {:statusCode 200
                      :body (-> mock-posts
                                (nth post-id)
                                clj->js
                                js/JSON.stringify)}))))

(defn save-post! [e ctx cb]
  (let [post (-> e util/clojurify-event :body js/JSON.parse util/clojurify-event)
        spit-posts! (partial spit "resources/posts.edn")
        sort-fn (partial sort-by :id >)]
    (-> post
        (assoc :id (count mock-posts))
        (cons mock-posts)
        sort-fn
        spit-posts!)
    (cb nil (clj->js {:statusCode 200}))))
