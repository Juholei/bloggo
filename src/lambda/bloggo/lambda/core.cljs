(ns bloggo.lambda.core
  (:require [bloggo.lambda.util :as util]))

(defn posts [e ctx cb]
  (println (-> e util/clojurify-event :path-parameters))
  (cb nil (clj->js {:statusCode 200
                    :body (-> [{:post "## Hello \n * jee \n * woah"
                                :title "This is a blog post"}
                               {:post "Quis optio quibusdam recusandae. Sed tempora vel natus necessitatibus aut nostrum. Eligendi qui non molestias est voluptatem molestias quos porro. Laborum veritatis minima ut voluptates molestiae aut occaecati quidem. Possimus nisi voluptas id amet quasi officiis quia. Cumque nihil laborum sint.

Et nesciunt eligendi itaque voluptas asperiores nihil quis ea. Harum cumque harum non qui cumque et illo quod. Dignissimos ut placeat iste placeat amet. Consequatur voluptatibus voluptatem quisquam.

Est excepturi iure nesciunt esse possimus provident quae. Reprehenderit temporibus id dolore et. Qui sunt magni saepe molestiae.

Corrupti eaque nihil et ex doloribus architecto officia iusto. Doloribus dolores aspernatur soluta aspernatur. Voluptatem corporis ipsum necessitatibus magnam quia temporibus totam. Tempora ex id qui ex quo est doloribus. Consectetur id minima qui ea ut dolore.

Ipsa est harum et consequatur temporibus qui. Ut optio non nisi rem voluptatem. Voluptate debitis qui culpa temporibus. Beatae atque sit mollitia vitae sunt. Optio sit animi aut."
                                :title "This is another blog post"}]
                              clj->js
                              js/JSON.stringify)})))



