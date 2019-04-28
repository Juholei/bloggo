(ns bloggo.lambda.core
  (:require [bloggo.lambda.util :as util]
            [clojure.string :as str]))

(def page-length 1)

(def mock-posts [{:post "## Hello \n * jee \n * woah"
                  :title "This is a blog post"
                  :id 0}
                 {:post "Quis optio quibusdam recusandae. Sed tempora vel natus necessitatibus aut nostrum. Eligendi qui non molestias est voluptatem molestias quos porro. Laborum veritatis minima ut voluptates molestiae aut occaecati quidem. Possimus nisi voluptas id amet quasi officiis quia. Cumque nihil laborum sint.

Et nesciunt eligendi itaque voluptas asperiores nihil quis ea. Harum cumque harum non qui cumque et illo quod. Dignissimos ut placeat iste placeat amet. Consequatur voluptatibus voluptatem quisquam.

Est excepturi iure nesciunt esse possimus provident quae. Reprehenderit temporibus id dolore et. Qui sunt magni saepe molestiae.

Corrupti eaque nihil et ex doloribus architecto officia iusto. Doloribus dolores aspernatur soluta aspernatur. Voluptatem corporis ipsum necessitatibus magnam quia temporibus totam. Tempora ex id qui ex quo est doloribus. Consectetur id minima qui ea ut dolore.

Ipsa est harum et consequatur temporibus qui. Ut optio non nisi rem voluptatem. Voluptate debitis qui culpa temporibus. Beatae atque sit mollitia vitae sunt. Optio sit animi aut."
                  :title "This is another blog post"
                  :id 1}])

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



