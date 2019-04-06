(ns bloggo.main.controllers.posts-test
  (:require [bloggo.main.controllers.posts :as sut]
            [cljs.test :refer [deftest testing is]]
            [tuck.core :as tuck]))

(def test-blog-post {:title "Test post"})

(deftest test-add-posts
  (testing "add-posts adds given posts to empty vector"
    (is (= (sut/add-posts [] [{:title "Test post"}])
           [{:title "Test post"}])))

  (testing "add-posts does not produce duplicate posts, if new posts are already in the existing"
    (is (= (sut/add-posts [{:title "Test post"}] [{:title "Test post"}])
           [{:title "Test post"}])))

  (testing "add-posts adds new posts to the end"
    (is (= (sut/add-posts [{:title "Old post"}] [{:title "New post"}])
           [{:title "Old post"} {:title "New post"}])))

  (testing "Tuck event AddPosts sets the posts in the correct place in the app-state"
    (is (= (tuck/process-event (sut/->AddPosts [{:title "Test post"}]) {})
           {:posts [{:title "Test post"}]}))))

